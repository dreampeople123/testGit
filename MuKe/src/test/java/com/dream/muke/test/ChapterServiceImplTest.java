package com.dream.muke.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.service.ChapterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ChapterServiceImplTest {
	@Autowired
	private ChapterService chapterService;
	
	@Test
	public void testFindAllChapters() {
		LogManager.getLogger().debug(chapterService.findAllChapters());
	}

	@Test
	public void testFindAllChapter() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindChapterBycNoOrchName() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("chName", "认识Java");
		map.put("cNo", 1000);
		LogManager.getLogger().debug(chapterService.findChapterBycNoOrchName(map));
	}

	@Test
	public void testShowChapterDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateChapterStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelChapterInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllChapterByCno() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindChapter() {
		fail("Not yet implemented");
	}

}
