package org.kosta.madfortaste.user.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.plaf.multi.MultiFileChooserUI;
import javax.validation.Valid;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.service.TastyPlaceService;
import org.kosta.madfortaste.user.domain.Owner;
import org.kosta.madfortaste.user.domain.OwnerForm;
import org.kosta.madfortaste.user.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwnerController {
	@Resource
	private OwnerService ownerService;
	@Autowired
	private TastyPlaceService tastyPlaceService;

	@RequestMapping(value="/{path}")
	public String ownerRegisterForm(@ModelAttribute OwnerForm ownerForm,@PathVariable String path) {
		return "user/"+path;
	}
	@RequestMapping("/register_access")
	public String ownerRegisterAccess(@Valid OwnerForm ownerForm,BindingResult result,Owner owner,TastyPlace tastyPlace){
		if(result.hasErrors()){
			return "user/ownerRegisterForm"; // 유효성 검사에 에러가 있으면 가입폼으로 다시 보낸다. 
		}
		ownerService.insertOwner(owner);//업주등록
		tastyPlaceService.insertTastyPlace(tastyPlace);//가게등록
		return "user/result/owner_register_result";
	}
}
