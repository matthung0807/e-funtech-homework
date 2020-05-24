package com.efuntech.hrm.dao;

import com.efuntech.hrm.entity.Base;
import com.efuntech.hrm.entity.Department;
import com.efuntech.hrm.repo.DepartmentRepo;
import com.efuntech.hrm.service.bo.DepartmentBo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentDaoImpl implements DepartmentDao {

    private final DepartmentRepo departmentRepo;

    @PostConstruct
    public void init(){
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        String creator = "SYSTEM";

        List<Department> departmentList = Arrays.asList(
                Department.builder().name("Marketing")
                        .createdAt(createTime)
                        .createdBy(creator)
                        .build(),
                Department.builder().name("HR")
                        .createdAt(createTime)
                        .createdBy(creator)
                        .build()
        );

        departmentRepo.saveAll(departmentList);
    }


    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepo.findById(id);
    }

    @Override
    public Optional<Department> findByName(String name) {
        return departmentRepo.findByName(name);
    }

    @Override
    public Optional<Long> add(DepartmentBo departmentBo) {
        Department department = Department.valueOf(departmentBo);
        department.setCreatedBy("USER");

        department = departmentRepo.save(department);
        return Optional.of(department)
                .map(Base::getId);
    }

    @Override
    public Optional<Long> update(DepartmentBo departmentBo) {
        return departmentRepo.findById(departmentBo.getId())
                .map(e -> {
                    e.setName(departmentBo.getName());
                    e.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    e.setUpdatedBy("USER");
                    return e;
                }).map(departmentRepo::save).map(Department::getId);
    }

    @Override
    public boolean delete(Long id) {
        departmentRepo.deleteById(id);
        return true;
    }
}
