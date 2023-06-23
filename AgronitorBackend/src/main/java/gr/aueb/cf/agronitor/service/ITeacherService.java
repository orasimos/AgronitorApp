package gr.aueb.cf.agronitor.service;

import gr.aueb.cf.agronitor.dto.TeacherDTO;
import gr.aueb.cf.agronitor.model.Teacher;
import gr.aueb.cf.agronitor.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface ITeacherService {
    Teacher insertTeacher(TeacherDTO teacherDTO);
    Teacher updateTeacher(TeacherDTO teacherDTO) throws EntityNotFoundException;
    void deleteTeacher(Long id) throws EntityNotFoundException;
    List<Teacher> getTeachersByLastname(String lastname) throws EntityNotFoundException;
    Teacher getTeacherById(Long id) throws EntityNotFoundException;
}
