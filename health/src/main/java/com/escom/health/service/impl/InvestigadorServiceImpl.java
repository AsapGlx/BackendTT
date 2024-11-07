package com.escom.health.service.impl;

import com.escom.health.model.Investigador;
import com.escom.health.repository.InvestigadorRepository;
import com.escom.health.service.InvestigadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InvestigadorServiceImpl implements InvestigadorService {

    @Autowired
    private InvestigadorRepository investigadorRepository;

    @Override
    public boolean addInvestigador(Investigador investigador) throws IOException {
        try {
            Investigador investigador1 = new Investigador(
                    investigador.getIdInvestigador(),
                    investigador.getNombre(),
                    investigador.getInstitucion(),
                    investigador.getAreaEspecializacion(),
                    investigador.getCorreoElectronico(),
                    investigador.getTelefono()

            );

            investigadorRepository.save(investigador1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Investigador> getInvestigador() {
        return investigadorRepository.findAll();

    }

    public Investigador getInvestigadorById(int id) {
        return investigadorRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateInvestigador(Investigador investigador , int id) throws IOException {
        try {
            Investigador investigadorTest = investigadorRepository.findById(id).orElse(null);

            if (investigadorTest != null){

                investigadorTest.setIdInvestigador(investigador.getIdInvestigador());
                investigadorTest.setNombre(investigador.getNombre());
                investigadorTest.setInstitucion(investigador.getInstitucion());
                investigadorTest.setAreaEspecializacion(investigador.getAreaEspecializacion());
                investigadorTest.setCorreoElectronico(investigador.getCorreoElectronico());
                investigadorTest.setTelefono(investigador.getTelefono());

                investigadorRepository.save(investigadorTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteInvestigador(int id) {
        try {
            Investigador test = investigadorRepository.findById(id).orElse(null);
            if ( test != null) {
                investigadorRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}



