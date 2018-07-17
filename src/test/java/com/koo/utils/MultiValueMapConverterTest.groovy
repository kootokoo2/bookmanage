package com.koo.utils

import com.koo.book.infra.SearchAppKey
import com.koo.book.application.SearchTarget
import spock.lang.Specification

class MultiValueMapConverterTest extends Specification {
	def "data get test" (){
		given:
		def target = SearchTarget.title
		def searchAppKey = new SearchAppKey()
		searchAppKey.setTarget(target)

		when:
		def result = MultiValueMapConverter.convert(searchAppKey)

		then:
		result.get("target").get(0) == target.name()
		result.size() == 1
	}


	
}
