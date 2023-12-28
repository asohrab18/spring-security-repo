package com.easybytes.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybytes.entity.Notice;
import com.easybytes.repository.NoticeRepository;

@RestController
public class NoticesController {

	@Autowired
	private NoticeRepository noticeRepository;

	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		if (notices != null) {
			//for 60 seconds, response is saved in cache & subsequent requests get response from cache. After completing 60 seconds, a new subsequent request will hit the backend/DB. 
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);
		} else {
			return null;
		}
	}

}