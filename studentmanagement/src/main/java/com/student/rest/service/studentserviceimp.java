package com.student.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.rest.dao.studentdao;
import com.student.rest.model.student;
import com.student.rest.response.basicresponsemsg;
import com.student.rest.response.studentrequestvo;

@Service
public class studentserviceimp implements studentservice {

	@Autowired
	studentdao studentdao;

	@Override
	public basicresponsemsg savestudent(studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();

		try {

			student std = new student();
			String address = studentrequestvo.getAddress();
			std.setAddress(address);
			std.setAge(studentrequestvo.getAge());
			std.setMobilenumber(studentrequestvo.getMobilenumber());
			std.setName(studentrequestvo.getName());
			std.setRollno(studentrequestvo.getRollno());

			student save = studentdao.save(std);

			response.setData(save.getId());
			response.setMessage("student saved");
			response.setStatus(200);

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

		return response;
	}

	@Override
	public basicresponsemsg getstudentbyid(studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();

		Optional<student> optional = studentdao.findById(studentrequestvo.getId());

		if (optional.isPresent()) {

			student student = optional.get();

			response.setMessage("data found");
			response.setStatus(200);
			response.setData(student);

		} else {
			response.setMessage("data  not found");
			response.setStatus(400);
		}

		return response;
	}

	@Override
	public basicresponsemsg getallstudent(studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();

		try {
			List<student> student = studentdao.findAll();

			if (!student.isEmpty()) {

				response.setStatus(200);
				response.setMessage("data found");
				response.setData(student);

			} else {
				response.setStatus(400);
				response.setMessage("data not  found");
				response.setData(student);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return response;
	}

	@Override
	public basicresponsemsg updatestudentbyid(studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();
		try {

			Optional<student> optional = studentdao.findById(studentrequestvo.getId());

			if (optional.isPresent()) {
				student student = optional.get();
				student.setName(studentrequestvo.getName());
				student.setAddress(studentrequestvo.getAddress());

				student studentt = studentdao.save(student);
				response.setStatus(200);
				response.setMessage("update succfully");
				response.setData(studentt);

			} else {
				response.setData(optional);
				response.setMessage("not update");
				response.setStatus(400);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@Override
	public basicresponsemsg deletebyid(studentrequestvo studentrequestvo) {
		basicresponsemsg response = new basicresponsemsg();

		try {

//			studentdao.deleteById(studentrequestvo.getId());
//		    response.setMessage( studentrequestvo.getId() +"delete succfully");
//		    response.setStatus(200);
//		    response.setData(studentrequestvo.getId());

			studentdao.deleteByIdCustom(studentrequestvo.getId());
			response.setMessage(studentrequestvo.getId() +"  "+"delete succfully");
			response.setStatus(200);
			response.setData(studentrequestvo.getId());

		} catch (Exception e) {
			response.setMessage("not delete");
			// TODO: handle exception

			e.printStackTrace();
		}

		return response;
	}

}
