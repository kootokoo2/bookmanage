package com.koo.book.domain.category;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Category {
	국내도서_소설(1),
	국내도서_시_에세이(3),
	국내도서_인문(5),
	국내도서_가정_생활(7),
	국내도서_요리(8),
	국내도서_건강(9),
	국내도서_취미_스포츠(11),
	국내도서_경제_경영(13),
	국내도서_자기계발(15),
	국내도서_정치_사회(17),
	국내도서_정부간행물(18),
	국내도서_역사_문화(19),
	국내도서_종교(21),
	국내도서_예술_대중문화(23),
	국내도서_중_고등학습(25),
	국내도서_기술_공학(26),
	국내도서_외국어(27),
	국내도서_과학(29),
	국내도서_취업_수험서(31),
	국내도서_여행_기행(32),
	국내도서_컴퓨터_IT(33),
	국내도서_잡지(35),
	국내도서_사전(37),
	국내도서_청소년(38),
	국내도서_초등참고서(39),
	국내도서_유아(41),
	국내도서_아동(42),
	국내도서_어린이영어(45),
	국내도서_만화(47),
	국내도서_대학교재(50),
	국내도서_어린이전집(51),
	국내도서_한국소개도서(53),
	e북_소설(901),
	e북_장르소설(902),
	e북_시_에세이(903),
	e북_경제_경영(904),
	e북_자기계발(905),
	e북_인문(906),
	e북_정치_사회(907),
	e북_로맨스_무협_판타지(908),
	e북_종교(909),
	e북_예술_대중문화(910),
	e북_가정_생활(911),
	e북_건강(912),
	e북_여행_취미(913),
	e북_청소년(914),
	e북_학습_수험서(915),
	e북_유아(916),
	e북_아동(917),
	e북_외국어_사전(918),
	e북_과학(919),
	e북_컴퓨터_IT(920),
	e북_잡지(921),
	e북_만화(922),
	e북_외국도서(923),
	e북_무료eBook(924),
	e북_개인출판(925),
	e북_오디오북(926),
	e북_연재(951),
	e북_eReader_Free(953),
	영미도서_문학(101),
	영미도서_취미_실용_여행(103),
	영미도서_생활_요리_건강(105),

	영미도서_예술_건축(107),

	영미도서_인문_사회(109),

	영미도서_경제_경영(111),

	영미도서_과학_기술(113),

	영미도서_아동(115),

	영미도서_한국관련도서(117),

	영미도서_NON_BOOK(119),

	영미도서_UMI(120),

	영미도서_ELT_영어교재(181),

	영미도서_어린이영어(183),

	영미도서_대학교재(191),

	영미도서_중국관련도서(194),

	일본도서_일서메인(239),

	일본도서_잡지(241),

	일본도서_엔터테인먼트(243),

	일본도서_만화(245),

	일본도서_문학(247),

	일본도서_라이트노벨(249),

	일본도서_문고_포켓북(251),

	일본도서_신서_포켓북(253),

	일본도서_아동(255),

	일본도서_실용서_예술(257),

	일본도서_인문_사회(259),

	일본도서_자연_기술과학(261),
	일본도서_어학_학습_사전(263),
	일본도서_문구_멀티_기타(264),
	일본도서_중국관련도서(267),
	프랑스도서_프랑스종합(486),
	독일도서_독일종합(588),
	스페인도서_스페인종합(690),
	미분류_미분류(0);

	private Integer categoryNumber;

	Category(Integer categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public static List<String> getSearchTargets() {
		return Arrays.asList(Category.values()).stream().map(a -> a.name())
			.collect(Collectors.toList());
	}
}





























































































