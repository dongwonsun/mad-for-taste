package org.kosta.madfortaste.user.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.service.TastyPlaceService;
import org.kosta.madfortaste.user.dao.MemberDao;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.Owner;
import org.kosta.madfortaste.user.domain.OwnerForm;
import org.kosta.madfortaste.user.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OwnerController {
	@Resource
	private OwnerService ownerService;
	@Autowired
	private TastyPlaceService tastyPlaceService;
	@Inject
	private MemberDao memberDao;

	@RequestMapping("owner_{path}")
	public String ownerRegisterForm(@ModelAttribute OwnerForm ownerForm,
			@PathVariable String path) {
		return "user/" + path;
	}
	@RequestMapping("pizzaMaru")
	public String pizzaMaru(String id,Model model){
		model.addAttribute("list", tastyPlaceService.selectTastyPlaceGetAllList(id));
		return "user/ownerBlog/pizzaMaru";
	}
	@RequestMapping(value="owner/{viewName1}/{viewName2}")
	public String test(@PathVariable String viewName1, @PathVariable String viewName2) {
		return "user/" + viewName1 + "/" +viewName2;
	}
	@RequestMapping("register_access")
	public String ownerRegisterAccess(@Valid OwnerForm ownerForm,
			BindingResult result, Owner owner, TastyPlace tastyPlace,HttpServletRequest req) {
		if (result.hasErrors()) {
			return "user/ownerRegisterForm"; // 유효성 검사에 에러가 있으면 가입폼으로 다시 보낸다.
		}
		ownerService.insertOwner(owner,req);// 업주등록
		tastyPlaceService.insertTastyPlace(tastyPlace);// 가게등록
		return "redirect:owner/result/owner_register_result?id="+owner.getOwnerId()+"&password="+owner.getPassword();
	}
	@RequestMapping("update_access")
	public String ownerUpdateAccess(Owner owner,HttpServletRequest req){
		ownerService.updateOwnerById(owner,req);
		return "redirect:reLogin";
	}
	@RequestMapping("idCheckAjax")
	@ResponseBody
	public List<String> ownerIdCheckAjax(String id) {
		Member member = null;
		Owner owner = null;
		List<String> list = new ArrayList<String>();
		String str = "사용가능";
		member = memberDao.selectMemberById(id);
		owner = ownerService.selectOwnerById(id);
		if (member != null||owner!=null)
			str = "사용불가";
		list.add(str);
		return list;
	}
	@RequestMapping("tastyIdCheckAjax")
	@ResponseBody
	public List<String> tastyIdCheckAjax(String id) {
		TastyPlace tastyPlace=null;
		List<String> list = new ArrayList<String>();
		String str = "사용가능";
		tastyPlace = tastyPlaceService.selectTastyPlaceById(id);
		if (tastyPlace != null)
			str = "사용불가";
		list.add(str);
		return list;
	}
}
