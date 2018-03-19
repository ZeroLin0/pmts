package com.demo.entity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/*
 * 分页*/
public class ExtPageable {
	private int page;
	private int limit;
	private String sort;
	private String dir;

	public void setPage(int page) {
		this.page = page;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Pageable getPageable() {
		Sort sortable = new Sort(Direction.DESC, sort);
		if (this.dir.toLowerCase().equals("asc")) {
			sortable = new Sort(Direction.ASC, sort);
		}
		Pageable pageable = new PageRequest(this.page - 1, this.limit, sortable);
		return pageable;
	}
}

