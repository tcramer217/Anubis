package com.anubis.homepage.service.search;

import com.anubis.homepage.data.search.SearchResponse;

public interface SearchService<T extends SearchResponse> {

    T doSearch();
}
