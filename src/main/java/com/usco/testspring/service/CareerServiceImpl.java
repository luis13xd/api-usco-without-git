package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.dto.CareerDtoUpdate;
import com.usco.testspring.dto.vo.PonderadoDto;
import com.usco.testspring.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CareerServiceImpl implements CareerService{
    private final CareerRepository careerRepository;
    private final FacultyServiceImpl facultyService;
    private final ModelMapper modelMapper;
    @Override
    public void save(CareerDto career) {
        Faculty faculty = facultyService.getFacultyById(career.getFaculty());
        Career careerToSave = modelMapper.map(career, Career.class);
        careerToSave.setFaculty(faculty);
        careerRepository.save(careerToSave);
    }

    @Override
    public List<Career> getAllCareers() {
        List<Career> nueva = (List<Career>) careerRepository.findAll();
        return nueva;
    }

    @Override
    public List<Career> getCareersByFaculty(UUID id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return careerRepository.findByFaculty(faculty);
    }

    @Override
    public Career getCareerById(UUID id) {
        Career career = careerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Career not found!"));
        return career;
    }

    @Override
    public Career updateCareer(UUID id, CareerDtoUpdate career) {
        System.out.println("Antes de buscarlo");
        Career careerFound = this.getCareerById(id);
        System.out.println(careerFound.toString());
        modelMapper.map(career, careerFound);
        if (career.getFaculty() != null) {
            Faculty faculty = facultyService.getFacultyById(career.getFaculty());
            careerFound.setFaculty(faculty);
        }
        careerFound.setLecturaCritica(career.getLecturaCritica()/100);
        careerFound.setCienciasNaturales(career.getCienciasNaturales()/100);
        careerFound.setCienciasSociales(career.getCienciasSociales()/100);
        careerFound.setMatematicas(career.getMatematicas()/100);
        careerFound.setIngles(career.getIngles()/100);

        Career careerUpdate = careerRepository.save(careerFound);
        System.out.println(careerUpdate);
        return careerUpdate;
    }

    @Override
    public void deleteCareer(String title) {
        Career career = this.findByTitle(title).get();
        System.out.println(career);
        System.out.println(this.getAllCareers().size());
        careerRepository.delete(career);
        System.out.println(this.getAllCareers().size());
    }

    @Override
    public Optional<Career> findByTitle(String title) {
        return careerRepository.findByTitle(title);
    }

    @Override
    public double calculatorPondereado(PonderadoDto ponderadoDto, CareerDtoUpdate career) {
        double resultado =  (ponderadoDto.getLecturaCritica() * career.getLecturaCritica())
                + ( ponderadoDto.getCienciasSociales() * career.getCienciasSociales()
                + (ponderadoDto.getIngles() * career.getIngles())
                + ( ponderadoDto.getMatematicas() * career.getMatematicas())
                + ( ponderadoDto.getCienciasNaturales() * career.getCienciasNaturales()));
        career.setPuntajePonderado(resultado);
        return resultado;
    }

    @Override
    public List<Career> calculatePonderados(PonderadoDto ponderadoDto) {
        List<Career> careerList = this.getAllCareers();
        List<Career> careerListNew = new ArrayList<>();
        for (Career c: careerList){
            double ponderado = this.calculatorPondereado(ponderadoDto,this.careerToCareerDto(c));
            System.out.println("antes: " + c.getPuntajePonderado());
            c.setPuntajePonderado(ponderado);
            System.out.println("despues: " + c.getPuntajePonderado());
            careerListNew.add(c);
        }
        return careerListNew;
    }

    private CareerDtoUpdate careerToCareerDto( Career dto){
        CareerDtoUpdate careerDtoUpdate = new CareerDtoUpdate();
        careerDtoUpdate.setCienciasNaturales(dto.getCienciasNaturales());
        careerDtoUpdate.setIngles(dto.getIngles());
        careerDtoUpdate.setMatematicas(dto.getMatematicas());
        careerDtoUpdate.setCienciasSociales(dto.getCienciasSociales());
        careerDtoUpdate.setLecturaCritica(dto.getLecturaCritica());
        careerDtoUpdate.setPuntajePonderado(dto.getPuntajePonderado());
        careerDtoUpdate.setPuntaCorte1(dto.getPuntaCorte1());
        careerDtoUpdate.setPuntaCorte2(dto.getPuntaCorte2());
        careerDtoUpdate.setTitle(dto.getTitle());
        careerDtoUpdate.setFaculty(dto.getFaculty().getId());
        return  careerDtoUpdate;
    }
}
