package br.com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.java.dao.EmployeeDAO;
import br.com.java.model.Employee;
import br.com.java.model.EmployeeForm;

import java.util.List;


@RestController
public class MainRESTController {

    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employees",method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeDAO.getEmployee(empId);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeForm empForm) {

        System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());

        return employeeDAO.addEmployee(empForm);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody EmployeeForm empForm) {

        System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());

        return employeeDAO.updateEmployee(empForm);
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empId") Long empId) {

        System.out.println("(Service Side) Deleting employee with Id: " + empId);

        employeeDAO.deleteEmployee(empId);
    }
}
