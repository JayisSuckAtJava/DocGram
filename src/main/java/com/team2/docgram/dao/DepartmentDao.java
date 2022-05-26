package com.team2.docgram.dao;

import com.team2.docgram.dto.DepartmentDto;
import com.team2.docgram.dto.UserDto;

public interface DepartmentDao {

	DepartmentDto readOne(Integer deptPk);

	UserDto readDeptList(Integer deptNum);

}
