package Service.config;

import Service.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import Service.entity.EmployeeEntity;
import com.Parameta.Prueba_Parameta.WebS.EmployeeAddRequest;
import com.Parameta.Prueba_Parameta.WebS.EmployeeAddResponse;
import com.Parameta.Prueba_Parameta.WebS.EmployeeType;
import com.Parameta.Prueba_Parameta.WebS.EmployeeServiceStatus;
import com.Parameta.ServiceSoap.service.EmployeeService;

@Endpoint

public class EmployeeEndpoint {

    public Static final String NAMESPACE_URI = "http://service.com/";

    @Autowired
    private EmployeeService service;;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeAddRequest")
    @ResponsePayload
    public EmployeeAddRequest addEmployee(@RequestPayload EmployeeAddRequest request)  {

        employeeAddResponse response = new EmployeeAddResponse();
        EmployeeType newemployeeType = new EmployeeType();
        EmployeeServiceStatus status = new EmployeeServiceStatus();

        EmployeeType empleado = new EmployeeType();

        empleado.setNombres(request.getEmployee().getNombres());
        empleado.setApellidos(request.getEmployee().getApellidos());
        empleado.setTipoDocumento(request.getEmployee().getTipoDocumento());
        empleado.setNumeroDocumento(request.getEmployee().getNumeroDocumento());
        empleado.setFechaNacimiento(request.getEmployee().getFechaNacimiento());
        empleado.setFechaVinculacion(request.getEmployee().getFechaVinculacion());
        empleado.setCargo(request.getEmployee().getCargo());
        empleado.setSalario(request.getEmployee().getSalario());

        EmployeeEntity employeeEntity = new EmployeeEntity(empleado.getID(), empleado.getNombres(),
                empleado.getApellidos(), empleado.getTipoDocumento(), empleado.getNumeroDocumento(),
                empleado.getFechaNacimiento(), empleado.getFechaVinculacion(), empleado.getCargo(),
                empleado.getSalario());

        EmployeeEntity savedEmployeeEntity = new EmployeeEntity();
        try {
            savedEmployeeEntity = service.addEmpleado(newemployeeType);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (savedEmployeeEntity == null) {
            serviceStatus.setStatusCode("confict");
            serviceStatus.setMessage("Exception while adding entity");
        } else {
            BeanUtils.copyProperties(savedEmpleadoEntity, newEmpleadoType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }
        EmployeeType newEmpleadoTypeResp = new EmployeeType();

        newEmpleadoTypeResp.setNombres(newEmpleadoEntity.getNombres());
        newEmpleadoTypeResp.setApellidos(newEmpleadoEntity.getApellidos());
        newEmpleadoTypeResp.setTipoDocumento(newEmpleadoEntity.getTipoDocumento());
        newEmpleadoTypeResp.setNumeroDocumento(newEmpleadoEntity.getNumeroDocumento());
        newEmpleadoTypeResp.setFechaNacimiento(newEmpleadoEntity.getFechaNacimiento());
        newEmpleadoTypeResp.setFechaVinculacion(newEmpleadoEntity.getFechaVinculacion());
        newEmpleadoTypeResp.setCargo(newEmpleadoEntity.getCargo());
        newEmpleadoTypeResp.setSalario(newEmpleadoEntity.getSalario());
        response.setEmpleado(newEmpleadoTypeResp);

        response.setServiceStatus(serviceStatus);
        return response;
    }
}
