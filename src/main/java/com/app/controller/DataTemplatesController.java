package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.DataTemplates;
import com.app.repository.DataTemplatesRepository;

@RestController
@RequestMapping("/app")
public class DataTemplatesController {

	Logger log = LoggerFactory.getLogger(DataTemplatesController.class);

	@Autowired
	DataTemplatesRepository dataTemplatesRepository;

	@GetMapping("/getDataTemplates")
	public List<DataTemplates> getDataTempaltes(@RequestParam(required=false) Long id, @RequestParam Boolean getAll) 
	{
		try {
			if( getAll == true )
				return dataTemplatesRepository.findAll();
			else {
				List<DataTemplates> list = new ArrayList<DataTemplates>();
				list.add(dataTemplatesRepository.findById(id).get());
				return list;
			}
		}
		catch(Exception exp) {
			log.error("Catch_Exception: In getDataTemplates, ",exp);
		}
		return null;
	}

	@DeleteMapping("/deleteDataTemplates")
	public List<DataTemplates> deleteDataTempalte(@RequestParam(required=false) Long id, @RequestParam Boolean deleteAll) 
	{
		try 
		{
			log.info("Delete Data Templates: {} or id: {}",deleteAll,id);
			if( deleteAll == true )
				dataTemplatesRepository.deleteAll();
			else 
				dataTemplatesRepository.deleteById(id);
			log.info("Size of Data Templates After Deleting: "+dataTemplatesRepository.findById(id));
			return dataTemplatesRepository.findAll();
		}
		catch(Exception exp) {
			log.error("Catch_Exception: In getDataTemplates, ",exp);
		}
		return null;
	}

	@PostMapping("/saveOrUpdateDataTemplates")
	public List<DataTemplates> saveOrUpdateDataTemplates(@RequestBody List<DataTemplates> dtList)
	{
		try {
			dtList.forEach( v ->{
				DataTemplates dt = new DataTemplates();
				dt = v;
				dt.setId(v.getId() != null ? v.getId() : null);
				log.info("Data Template: "+dt.toString());
				dataTemplatesRepository.save(v);
			});
			log.info("Saved Data Templates");
			return dataTemplatesRepository.findAll();
		}
		catch(Exception exp)
		{
			log.error("Catch_Exception: In saveDataTemplates, ",exp);
		}
		return null;
	}

}
