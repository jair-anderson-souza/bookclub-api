package io.github.jass2125.beer.api.infraestrutura.query;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 19 de out de 2018
 * @project bids-api
 *
 **/
public class Paginacao implements Pageable {

	private PageRequest pageRequest;
	private Integer page;
	private Integer size;

	public Paginacao() {

	}

	public void init() {
		if (pageRequest == null) {
			final int pagina = page == null || page < 0 ? 0 : page;
			final int tamanho = size == null || size > 25 ? 10 : size;

			pageRequest = new PageRequest(pagina, tamanho);
		}
	}

	@Override
	public int getPageNumber() {
		init();
		return this.pageRequest.getPageNumber();
	}

	@Override
	public int getPageSize() {
		init();
		return this.pageRequest.getPageSize();
	}

	@Override
	public int getOffset() {
		init();
		return this.pageRequest.getOffset();
	}

	@Override
	public Sort getSort() {
		init();
		return this.pageRequest.getSort();
	}

	@Override
	public Pageable next() {
		init();
		return this.pageRequest.next();
	}

	@Override
	public Pageable previousOrFirst() {
		init();
		return this.pageRequest.previousOrFirst();
	}

	@Override
	public Pageable first() {
		init();
		return this.pageRequest.first();
	}

	@Override
	public boolean hasPrevious() {
		init();
		return this.pageRequest.hasPrevious();
	}

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
