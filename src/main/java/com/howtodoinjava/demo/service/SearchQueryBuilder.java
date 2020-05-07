package com.howtodoinjava.demo.service;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.howtodoinjava.demo.model.MasterData;
import com.howtodoinjava.demo.model.SampleData;

@Component
public class SearchQueryBuilder {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public List<MasterData> searchMasterDataByValue(String text) {

		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.queryStringQuery(text).lenient(true).field("value"))
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("value"));

		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

		List<MasterData> dataList = elasticsearchTemplate.queryForList(build, MasterData.class);

		return dataList;
	}

	public List<MasterData> searchMasterDataByValue(String type, String text) {

		/*
		 * QueryBuilder query = QueryBuilders.boolQuery() .should(
		 * QueryBuilders.queryStringQuery(text) .lenient(true) .field("value")
		 * ).should(QueryBuilders.queryStringQuery("*" + text + "*") .lenient(true)
		 * .field("value")); QueryBuilder query = QueryBuilders.boolQuery()
		 * .must(QueryBuilders.queryStringQuery(type).field("dataType"))
		 * .should(QueryBuilders.queryStringQuery("*" + text + "*").field("value"));
		 */

		BoolQueryBuilder query = QueryBuilders.boolQuery();
		QueryBuilder qb1 = QueryBuilders.matchPhraseQuery("dataType", type);
		QueryBuilder qb2 = QueryBuilders.queryStringQuery("*" + text + "*").field("value");
		query.must(qb1);
		query.must(qb2);

		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

		List<MasterData> dataList = elasticsearchTemplate.queryForList(build, MasterData.class);

		return dataList;
	}
	
	public List<SampleData> searchSampleDataByValue(String text) {

		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("rand1"))
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("rand2"))
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("rand3"))
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("rand4"))
				.should(QueryBuilders.queryStringQuery("*" + text + "*").lenient(true).field("fixed"));

		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

		List<SampleData> dataList = elasticsearchTemplate.queryForList(build, SampleData.class);

		return dataList;
	}
	
	public List<SampleData> searchSampleDataByValue(String type, String text) {

		BoolQueryBuilder query = QueryBuilders.boolQuery();
		QueryBuilder qb1 = QueryBuilders.matchPhraseQuery("dataType", type);
		QueryBuilder qb2 = QueryBuilders.queryStringQuery("*" + text + "*").field("value");
		query.must(qb1);
		query.must(qb2);

		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

		List<SampleData> dataList = elasticsearchTemplate.queryForList(build, SampleData.class);

		return dataList;
	}
}
