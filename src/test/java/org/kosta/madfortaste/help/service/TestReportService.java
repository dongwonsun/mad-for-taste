package org.kosta.madfortaste.help.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestReportService {
	
	@Autowired
	private ReportService reportService;
	
	@Before
	public void setUp() {
		assertNotNull(reportService);
	}
	
	@Transactional
	@Test
	public void testBlindArticle() {
		String boardName = "TASTEBOARD";
		int articleNo = 1;
		reportService.blindArticle(boardName, articleNo);
	}
	
}
