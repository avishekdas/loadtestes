package com.abp.search.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.MultiSearchResponse.Item;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.facet.FacetRequest;
import org.springframework.data.elasticsearch.core.query.IndexBoost;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.ScriptField;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.abp.search.dto.PPUserInputDTO;
import com.abp.search.dto.UserInputDTO;
import com.abp.search.es.model.AbstractPPUserDAO;
import com.abp.search.es.model.AbstractUserDAO;
import com.abp.search.es.model.MasterData;
import com.abp.search.es.model.SampleData;


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

	public List<AbstractUserDAO> searchUserData(UserInputDTO userData) {
		List<AbstractUserDAO> dataList = new ArrayList<AbstractUserDAO>();
		if (userData != null) {
			BoolQueryBuilder query = QueryBuilders.boolQuery();
			if (userData.getPhysicalappearance() != null && !"".equalsIgnoreCase(userData.getPhysicalappearance())) {
				QueryBuilder qb2 = QueryBuilders.queryStringQuery("*" + userData.getPhysicalappearance() + "*")
						.field("physicalappearance");
				query.must(qb2);
			}
			NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

			dataList = elasticsearchTemplate.queryForList(build, AbstractUserDAO.class);
		}

		return dataList;
	}

	public List<AbstractPPUserDAO> searchPPUserData(PPUserInputDTO ppUserData) {
		List<AbstractPPUserDAO> dataList = new ArrayList<AbstractPPUserDAO>();
		if (ppUserData != null) {
			BoolQueryBuilder query = QueryBuilders.boolQuery();
			if (ppUserData.getAboutpartner() != null && !"".equalsIgnoreCase(ppUserData.getAboutpartner())) {
				QueryBuilder qb2 = QueryBuilders.queryStringQuery("*" + ppUserData.getAboutpartner() + "*")
						.field("aboutpartner");
				query.must(qb2);
			}
			NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

			dataList = elasticsearchTemplate.queryForList(build, AbstractPPUserDAO.class);
		}

		return dataList;
	}

	public YYY findBy(XXX xxx) {
		Client client = elasticsearchTemplate.getClient();
		MultiSearchRequest request = new MultiSearchRequest();
		// build searchQuery like normal
		for (NativeSearchQuery searchQuery : queries) {
			request.add(prepareSearch(client, searchQuery));
		}
		ActionFuture<MultiSearchResponse> future = client.multiSearch(request);
		MultiSearchResponse response = future.actionGet();
		Item[] items = response.getResponses();
		for (int i = 0; i < items.length; i++) {
			AggregatedPage<XXX> ts = resultMapper.mapResults(items[i].getResponse(), XXX.class, page);
			// do with page
		}
	}

	private SearchRequestBuilder prepareSearch(Client client, SearchQuery searchQuery) {
		Assert.notNull(searchQuery.getIndices(), "No index defined for Query");
		Assert.notNull(searchQuery.getTypes(), "No type defined for Query");

		int startRecord = 0;
		SearchRequestBuilder searchRequest = client.prepareSearch(toArray(searchQuery.getIndices()))
				.setSearchType(searchQuery.getSearchType()).setTypes(toArray(searchQuery.getTypes()));

		if (searchQuery.getSourceFilter() != null) {
			SourceFilter sourceFilter = searchQuery.getSourceFilter();
			searchRequest.setFetchSource(sourceFilter.getIncludes(), sourceFilter.getExcludes());
		}

		if (searchQuery.getPageable().isPaged()) {
			startRecord = searchQuery.getPageable().getPageNumber() * searchQuery.getPageable().getPageSize();
			searchRequest.setSize(searchQuery.getPageable().getPageSize());
		}
		searchRequest.setFrom(startRecord);

		if (!searchQuery.getFields().isEmpty()) {
			searchRequest.setFetchSource(toArray(searchQuery.getFields()), null);
		}

		if (searchQuery.getSort() != null) {
			for (Sort.Order order : searchQuery.getSort()) {
				searchRequest.addSort(order.getProperty(),
						order.getDirection() == Sort.Direction.DESC ? SortOrder.DESC : SortOrder.ASC);
			}
		}

		if (searchQuery.getMinScore() > 0) {
			searchRequest.setMinScore(searchQuery.getMinScore());
		}

		if (searchQuery.getFilter() != null) {
			searchRequest.setPostFilter(searchQuery.getFilter());
		}

		if (!isEmpty(searchQuery.getElasticsearchSorts())) {
			for (SortBuilder sort : searchQuery.getElasticsearchSorts()) {
				searchRequest.addSort(sort);
			}
		}

		if (!searchQuery.getScriptFields().isEmpty()) {
			// _source should be return all the time
			// searchRequest.addStoredField("_source");
			for (ScriptField scriptedField : searchQuery.getScriptFields()) {
				searchRequest.addScriptField(scriptedField.fieldName(), scriptedField.script());
			}
		}

		if (searchQuery.getHighlightFields() != null) {
			for (HighlightBuilder.Field highlightField : searchQuery.getHighlightFields()) {
				searchRequest.highlighter(new HighlightBuilder().field(highlightField));
			}
		}

		if (!isEmpty(searchQuery.getIndicesBoost())) {
			for (IndexBoost indexBoost : searchQuery.getIndicesBoost()) {
				searchRequest.addIndexBoost(indexBoost.getIndexName(), indexBoost.getBoost());
			}
		}

		if (!isEmpty(searchQuery.getAggregations())) {
			for (AbstractAggregationBuilder aggregationBuilder : searchQuery.getAggregations()) {
				searchRequest.addAggregation(aggregationBuilder);
			}
		}

		if (!isEmpty(searchQuery.getFacets())) {
			for (FacetRequest aggregatedFacet : searchQuery.getFacets()) {
				searchRequest.addAggregation(aggregatedFacet.getFacet());
			}
		}

		return searchRequest.setQuery(searchQuery.getQuery());
	}
}
