package com.team2.docgram.dao;

import com.team2.docgram.dto.DepartmentDto;

public interface DepartmentDao {

	DepartmentDto readOne(Integer deptPk);

}
