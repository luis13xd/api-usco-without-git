package com.usco.testspring.service;

import com.usco.testspring.domain.DataEncuesta;
import com.usco.testspring.domain.GeneralReport;
import com.usco.testspring.domain.ResponseDataEncuenta;
import com.usco.testspring.repository.DataResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RecommenderService {
    private final DataResponseRepository repository;
    String MEDICINA = "MEDICINA";
    String ENFERMERIA = "ENFERMERIA";
    String ECONOMIA = "ECONOMIA";
    String ADMINISTRACIONEMPRESAS = "ADMINISTRACIONEMPRESAS";
    String CONTADURIAPUBLICA = "CONTADURIAPUBLICA";
    String ADMINISTRACIONFINANCIERA = "ADMINISTRACIONFINANCIERA";
    String ADMINISTRACIONTURISTICAHOTELERA = "ADMINISTRACIONTURISTICAHOTELERA";
    String COMUNICACIONSOCIALPERIODISMO = "COMUNICACIONSOCIALPERIODISMO";
    String PSICOLOGIA = "PSICOLOGIA";
    String ANTROPOLOGIA = "ANTROPOLOGIA";
    String DERECHO = "DERECHO";
    String CIENCIAPOLITICA = "CIENCIAPOLITICA";
    String MATEMATICAAPLICADA = "MATEMATICAAPLICADA";
    String FISICA = "FISICA";
    String BIOLOGIAAPLICADA = "BIOLOGIAAPLICADA";
    String LICENCIATURAINGLES = "LICENCIATURAINGLES";
    String LICENCIATURALENGUACASTELLANA = "LICENCIATURALENGUACASTELLANA";
    String LICENCIATURACIENCIASNATURALES = "LICENCIATURACIENCIASNATURALES";
    String LICENCIATURAEDUCACIONFISICA = "LICENCIATURAEDUCACIONFISICA";
    String LICENCIATURAEDUCACIONARTISTICA = "LICENCIATURAEDUCACIONARTISTICA";
    String LICENCIATURAEDUCACIONINFANTIL = "LICENCIATURAEDUCACIONINFANTIL";
    String LICENCIATURAMATEMATICAS = "LICENCIATURAMATEMATICAS";
    String LICENCIATURACIENCIASSOCIALES = "LICENCIATURACIENCIASSOCIALES";
    String INGENIERIAAGRICOLA = "INGENIERIAAGRICOLA";
    String INGENIERIAAGROINDUSTRIAL = "INGENIERIAAGROINDUSTRIAL";
    String INGENIERIAELECTRONICA = "INGENIERIAELECTRONICA";
    String INGENIERIAPETROLEOS = "INGENIERIAPETROLEOS";
    String INGENIERIASOFTWARE = "INGENIERIASOFTWARE";
    String INGENIERIACIVIL = "INGENIERIACIVIL";
    String TECNOLOGIADESARROLLOSSOFTWARE = "TECNOLOGIADESARROLLOSSOFTWARE";
    String TECNOLOGIAOBRASCIVILES = "TECNOLOGIAOBRASCIVILES";

    double MEDICINA_SCORE = 0;
    double ENFERMERIA_SCORE = 0;
    double ECONOMIA_SCORE = 0;
    double ADMINISTRACIONEMPRESAS_SCORE = 0;
    double CONTADURIAPUBLICA_SCORE = 0;
    double ADMINISTRACIONFINANCIERA_SCORE = 0;
    double ADMINISTRACIONTURISTICAHOTELERA_SCORE = 0;
    double COMUNICACIONSOCIALPERIODISMO_SCORE = 0;
    double PSICOLOGIA_SCORE = 0;
    double ANTROPOLOGIA_SCORE = 0;
    double DERECHO_SCORE = 0;
    double CIENCIAPOLITICA_SCORE = 0;
    double MATEMATICAAPLICADA_SCORE = 0;
    double FISICA_SCORE = 0;
    double BIOLOGIAAPLICADA_SCORE = 0;
    double LICENCIATURAINGLES_SCORE = 0;
    double LICENCIATURALENGUACASTELLANA_SCORE = 0;
    double LICENCIATURACIENCIASNATURALES_SCORE = 0;
    double LICENCIATURAEDUCACIONFISICA_SCORE = 0;
    double LICENCIATURAEDUCACIONARTISTICA_SCORE = 0;
    double LICENCIATURAEDUCACIONINFANTIL_SCORE = 0;
    double LICENCIATURAMATEMATICAS_SCORE = 0;
    double LICENCIATURACIENCIASSOCIALES_SCORE = 0;
    double INGENIERIAAGRICOLA_SCORE = 0;
    double INGENIERIAAGROINDUSTRIAL_SCORE = 0;
    double INGENIERIAELECTRONICA_SCORE = 0;
    double INGENIERIAPETROLEOS_SCORE = 0;
    double INGENIERIASOFTWARE_SCORE = 0;
    double INGENIERIACIVIL_SCORE = 0;
    double TECNOLOGIADESARROLLOSSOFTWARE_SCORE = 0;
    double TECNOLOGIAOBRASCIVILES_SCORE = 0;

    public List<ResponseDataEncuenta> recomendar(List<DataEncuesta> data, String userDcoument){
        List<ResponseDataEncuenta> responseDataEncuentas = new ArrayList<>();
        for (DataEncuesta d : data){
            if(d.getCarrera().equalsIgnoreCase(MEDICINA)){
                MEDICINA_SCORE += d.getPuntaje();
            }
            if(d.getCarrera().equalsIgnoreCase(ENFERMERIA)){
                ENFERMERIA_SCORE += d.getPuntaje();
            }
            if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONEMPRESAS)){
                ADMINISTRACIONEMPRESAS_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(ECONOMIA)){
                ECONOMIA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(CONTADURIAPUBLICA)){
                CONTADURIAPUBLICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONFINANCIERA)){
                ADMINISTRACIONFINANCIERA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONTURISTICAHOTELERA)){
                ADMINISTRACIONTURISTICAHOTELERA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(COMUNICACIONSOCIALPERIODISMO)){
                COMUNICACIONSOCIALPERIODISMO_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(PSICOLOGIA)){
                PSICOLOGIA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(ANTROPOLOGIA)){
                ANTROPOLOGIA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(DERECHO)){
                DERECHO_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(CIENCIAPOLITICA)){
                CIENCIAPOLITICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(MATEMATICAAPLICADA)){
                MATEMATICAAPLICADA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(FISICA)){
                FISICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(BIOLOGIAAPLICADA)){
                BIOLOGIAAPLICADA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAINGLES)){
                LICENCIATURAINGLES_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURALENGUACASTELLANA)){
                LICENCIATURALENGUACASTELLANA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURACIENCIASNATURALES)){
                LICENCIATURACIENCIASNATURALES_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONFISICA)){
                LICENCIATURAEDUCACIONFISICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONARTISTICA)){
                LICENCIATURAEDUCACIONARTISTICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONINFANTIL)){
                LICENCIATURAEDUCACIONINFANTIL_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAMATEMATICAS)){
                LICENCIATURAMATEMATICAS_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURACIENCIASSOCIALES)){
                LICENCIATURACIENCIASSOCIALES_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAAGRICOLA)){
                INGENIERIAAGRICOLA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAAGROINDUSTRIAL)){
                INGENIERIAAGROINDUSTRIAL_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAELECTRONICA)){
                INGENIERIAELECTRONICA_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAPETROLEOS)){
                INGENIERIAPETROLEOS_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIASOFTWARE)){
                INGENIERIASOFTWARE_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIACIVIL)){
                INGENIERIACIVIL_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(TECNOLOGIADESARROLLOSSOFTWARE)){
                TECNOLOGIADESARROLLOSSOFTWARE_SCORE += d.getPuntaje();
            }if(d.getCarrera().equalsIgnoreCase(TECNOLOGIAOBRASCIVILES)){
                TECNOLOGIAOBRASCIVILES_SCORE += d.getPuntaje();
            }

        }
        UUID uuid = UUID.randomUUID();
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"TECNOLOGÍA EN OBRAS CIVILES",TECNOLOGIAOBRASCIVILES_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"TECNOLOGÍA EN DESARROLLO DE SOFTWARE",TECNOLOGIADESARROLLOSSOFTWARE_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA CIVIL",INGENIERIACIVIL_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA DE PETRÓLEOS",INGENIERIAPETROLEOS_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA ELECTRÓNICA",INGENIERIAELECTRONICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA AGROINDUSTRIAL",INGENIERIAAGROINDUSTRIAL_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA AGRÍCOLA",INGENIERIAAGRICOLA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN CIENCIAS SOCIALES",LICENCIATURACIENCIASSOCIALES_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN EDUCACIÓN INFANTIL",LICENCIATURAEDUCACIONINFANTIL_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN EDUCACIÓN ARTÍSTICA",LICENCIATURAEDUCACIONARTISTICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN EDUCACIÓN FÍSICA",LICENCIATURAEDUCACIONFISICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN CIENCIAS NATURALES",LICENCIATURACIENCIASNATURALES_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN LENGUA CASTELLANA",LICENCIATURALENGUACASTELLANA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"BIOLOGÍA APLICADA",BIOLOGIAAPLICADA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"FÍSICA",FISICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"MATEMÁTICA APLICADA",MATEMATICAAPLICADA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"CIENCIA POLÍTICA",CIENCIAPOLITICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"DERECHO",DERECHO_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ANTROPOLOGÍA",ANTROPOLOGIA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"PSICOLOGÍA",PSICOLOGIA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"COMUNICACIÓN SOCIAL Y PERIODISMO",COMUNICACIONSOCIALPERIODISMO_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ADMINISTRACIÓN TURÍSTICA Y HOTELERA",ADMINISTRACIONTURISTICAHOTELERA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ADMINISTRACIÓN FINANCIERA",ADMINISTRACIONFINANCIERA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"CONTADURÍA PÚBLICA",CONTADURIAPUBLICA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ECONOMÍA",ECONOMIA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ADMINISTRACIÓN DE EMPRESAS",ADMINISTRACIONEMPRESAS_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"ENFERMERÍA",ENFERMERIA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"MEDICINA",MEDICINA_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN MATEMÁTICAS",LICENCIATURAMATEMATICAS_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"INGENIERÍA DE SOFTWARE",INGENIERIASOFTWARE_SCORE / 2,uuid,userDcoument));
        responseDataEncuentas.add(new ResponseDataEncuenta(uuid,"LICENCIATURA EN INGLÉS",LICENCIATURAINGLES_SCORE / 2,uuid,userDcoument));
        for(ResponseDataEncuenta r: responseDataEncuentas){
            UUID uuidV = UUID.randomUUID();
            r.setId(uuidV);
            r.setPorcentaje(r.getPorcentaje()*100 / 5);
        }
        MEDICINA_SCORE = 0;
        ENFERMERIA_SCORE = 0;
        ECONOMIA_SCORE = 0;
        ADMINISTRACIONEMPRESAS_SCORE = 0;
        CONTADURIAPUBLICA_SCORE = 0;
        ADMINISTRACIONFINANCIERA_SCORE = 0;
        ADMINISTRACIONTURISTICAHOTELERA_SCORE = 0;
        COMUNICACIONSOCIALPERIODISMO_SCORE = 0;
        PSICOLOGIA_SCORE = 0;
        ANTROPOLOGIA_SCORE = 0;
        DERECHO_SCORE = 0;
        CIENCIAPOLITICA_SCORE = 0;
        MATEMATICAAPLICADA_SCORE = 0;
        FISICA_SCORE = 0;
        BIOLOGIAAPLICADA_SCORE = 0;
        LICENCIATURAINGLES_SCORE = 0;
        LICENCIATURALENGUACASTELLANA_SCORE = 0;
        LICENCIATURACIENCIASNATURALES_SCORE = 0;
        LICENCIATURAEDUCACIONFISICA_SCORE = 0;
        LICENCIATURAEDUCACIONARTISTICA_SCORE = 0;
        LICENCIATURAEDUCACIONINFANTIL_SCORE = 0;
        LICENCIATURAMATEMATICAS_SCORE = 0;
        LICENCIATURACIENCIASSOCIALES_SCORE = 0;
        INGENIERIAAGRICOLA_SCORE = 0;
        INGENIERIAAGROINDUSTRIAL_SCORE = 0;
        INGENIERIAELECTRONICA_SCORE = 0;
        INGENIERIAPETROLEOS_SCORE = 0;
        INGENIERIASOFTWARE_SCORE = 0;
        INGENIERIACIVIL_SCORE = 0;
        TECNOLOGIADESARROLLOSSOFTWARE_SCORE = 0;
        TECNOLOGIAOBRASCIVILES_SCORE = 0;
        return responseDataEncuentas;
    }


    public List<GeneralReport> promedioGeneral(){
        List<ResponseDataEncuenta> data = (List<ResponseDataEncuenta>) repository.findAll();
        int numberStudents = data.size() / 62 ;
        List<GeneralReport> responseDataEncuentas = new ArrayList<>();
        for (ResponseDataEncuenta d : data){
            if(d.getCarrera().equalsIgnoreCase(MEDICINA)){
                MEDICINA_SCORE += d.getPorcentaje();
            }
            if(d.getCarrera().equalsIgnoreCase(ENFERMERIA)){
                ENFERMERIA_SCORE += d.getPorcentaje();
            }
            if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONEMPRESAS)){
                ADMINISTRACIONEMPRESAS_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(ECONOMIA)){
                ECONOMIA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(CONTADURIAPUBLICA)){
                CONTADURIAPUBLICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONFINANCIERA)){
                ADMINISTRACIONFINANCIERA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(ADMINISTRACIONTURISTICAHOTELERA)){
                ADMINISTRACIONTURISTICAHOTELERA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(COMUNICACIONSOCIALPERIODISMO)){
                COMUNICACIONSOCIALPERIODISMO_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(PSICOLOGIA)){
                PSICOLOGIA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(ANTROPOLOGIA)){
                ANTROPOLOGIA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(DERECHO)){
                DERECHO_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(CIENCIAPOLITICA)){
                CIENCIAPOLITICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(MATEMATICAAPLICADA)){
                MATEMATICAAPLICADA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(FISICA)){
                FISICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(BIOLOGIAAPLICADA)){
                BIOLOGIAAPLICADA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAINGLES)){
                LICENCIATURAINGLES_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURALENGUACASTELLANA)){
                LICENCIATURALENGUACASTELLANA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURACIENCIASNATURALES)){
                LICENCIATURACIENCIASNATURALES_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONFISICA)){
                LICENCIATURAEDUCACIONFISICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONARTISTICA)){
                LICENCIATURAEDUCACIONARTISTICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAEDUCACIONINFANTIL)){
                LICENCIATURAEDUCACIONINFANTIL_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURAMATEMATICAS)){
                LICENCIATURAMATEMATICAS_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(LICENCIATURACIENCIASSOCIALES)){
                LICENCIATURACIENCIASSOCIALES_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAAGRICOLA)){
                INGENIERIAAGRICOLA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAAGROINDUSTRIAL)){
                INGENIERIAAGROINDUSTRIAL_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAELECTRONICA)){
                INGENIERIAELECTRONICA_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIAPETROLEOS)){
                INGENIERIAPETROLEOS_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIASOFTWARE)){
                INGENIERIASOFTWARE_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(INGENIERIACIVIL)){
                INGENIERIACIVIL_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(TECNOLOGIADESARROLLOSSOFTWARE)){
                TECNOLOGIADESARROLLOSSOFTWARE_SCORE += d.getPorcentaje();
            }if(d.getCarrera().equalsIgnoreCase(TECNOLOGIAOBRASCIVILES)){
                TECNOLOGIAOBRASCIVILES_SCORE += d.getPorcentaje();
            }

        }
        UUID uuid = UUID.randomUUID();
        responseDataEncuentas.add(new GeneralReport(uuid,TECNOLOGIAOBRASCIVILES,TECNOLOGIAOBRASCIVILES_SCORE / numberStudents *  2,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,TECNOLOGIADESARROLLOSSOFTWARE,TECNOLOGIADESARROLLOSSOFTWARE_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIACIVIL,INGENIERIACIVIL_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIAPETROLEOS,INGENIERIAPETROLEOS_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIAELECTRONICA,INGENIERIAELECTRONICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIAAGROINDUSTRIAL,INGENIERIAAGROINDUSTRIAL_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIAAGRICOLA,INGENIERIAAGRICOLA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURACIENCIASSOCIALES,LICENCIATURACIENCIASSOCIALES_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURAEDUCACIONINFANTIL,LICENCIATURAEDUCACIONINFANTIL_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURAEDUCACIONARTISTICA,LICENCIATURAEDUCACIONARTISTICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURAEDUCACIONFISICA,LICENCIATURAEDUCACIONFISICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURACIENCIASNATURALES,LICENCIATURACIENCIASNATURALES_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURALENGUACASTELLANA,LICENCIATURALENGUACASTELLANA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,BIOLOGIAAPLICADA,BIOLOGIAAPLICADA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,FISICA,FISICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,MATEMATICAAPLICADA,MATEMATICAAPLICADA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,CIENCIAPOLITICA,CIENCIAPOLITICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,DERECHO,DERECHO_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ANTROPOLOGIA,ANTROPOLOGIA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,PSICOLOGIA,PSICOLOGIA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,COMUNICACIONSOCIALPERIODISMO,COMUNICACIONSOCIALPERIODISMO_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ADMINISTRACIONTURISTICAHOTELERA,ADMINISTRACIONTURISTICAHOTELERA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ADMINISTRACIONFINANCIERA,ADMINISTRACIONFINANCIERA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,CONTADURIAPUBLICA,CONTADURIAPUBLICA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ECONOMIA,ECONOMIA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ADMINISTRACIONEMPRESAS,ADMINISTRACIONEMPRESAS_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,ENFERMERIA,ENFERMERIA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,MEDICINA,MEDICINA_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURAMATEMATICAS,LICENCIATURAMATEMATICAS_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,INGENIERIASOFTWARE,INGENIERIASOFTWARE_SCORE / numberStudents * 2 ,uuid));
        responseDataEncuentas.add(new GeneralReport(uuid,LICENCIATURAINGLES,LICENCIATURAINGLES_SCORE / numberStudents * 2 ,uuid));


        for(GeneralReport r: responseDataEncuentas){
            UUID uuidV = UUID.randomUUID();
            r.setId(uuidV);
            r.setPuntaje(r.getPuntaje() / 5);
        }
        MEDICINA_SCORE = 0;
        ENFERMERIA_SCORE = 0;
        ECONOMIA_SCORE = 0;
        ADMINISTRACIONEMPRESAS_SCORE = 0;
        CONTADURIAPUBLICA_SCORE = 0;
        ADMINISTRACIONFINANCIERA_SCORE = 0;
        ADMINISTRACIONTURISTICAHOTELERA_SCORE = 0;
        COMUNICACIONSOCIALPERIODISMO_SCORE = 0;
        PSICOLOGIA_SCORE = 0;
        ANTROPOLOGIA_SCORE = 0;
        DERECHO_SCORE = 0;
        CIENCIAPOLITICA_SCORE = 0;
        MATEMATICAAPLICADA_SCORE = 0;
        FISICA_SCORE = 0;
        BIOLOGIAAPLICADA_SCORE = 0;
        LICENCIATURAINGLES_SCORE = 0;
        LICENCIATURALENGUACASTELLANA_SCORE = 0;
        LICENCIATURACIENCIASNATURALES_SCORE = 0;
        LICENCIATURAEDUCACIONFISICA_SCORE = 0;
        LICENCIATURAEDUCACIONARTISTICA_SCORE = 0;
        LICENCIATURAEDUCACIONINFANTIL_SCORE = 0;
        LICENCIATURAMATEMATICAS_SCORE = 0;
        LICENCIATURACIENCIASSOCIALES_SCORE = 0;
        INGENIERIAAGRICOLA_SCORE = 0;
        INGENIERIAAGROINDUSTRIAL_SCORE = 0;
        INGENIERIAELECTRONICA_SCORE = 0;
        INGENIERIAPETROLEOS_SCORE = 0;
        INGENIERIASOFTWARE_SCORE = 0;
        INGENIERIACIVIL_SCORE = 0;
        TECNOLOGIADESARROLLOSSOFTWARE_SCORE = 0;
        TECNOLOGIAOBRASCIVILES_SCORE = 0;
        return responseDataEncuentas;
    }

}
