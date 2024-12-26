package io.reflectoring.buckpal.account.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import lombok.Getter;
import lombok.Setter;

class AccountPersistenceAdapterTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldMapSuccess() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProblemCreateDTO dto = new ProblemCreateDTO();
		dto.setCategoryId(1L);
		dto.setCategoryName("My Category");

		Problem problem = modelMapper.map(dto, Problem.class);
		System.err.println(problem.getId());
		System.err.println(problem.getCategory());
		System.err.println(dto.getCategoryId()+">"+problem.getCategory().getId());
		System.err.println(dto.getCategoryName()+">"+problem.getCategory().getName());
	}

	@Getter
	@Setter
	static class ProblemCreateDTO {
		private Long categoryId;
		private String categoryName;
	}

	@Getter
	@Setter
	static class Problem {
		private Long id;
		private Category category;
	}

	@Getter
	@Setter
	static class Category {
		private Long id;
		private String name;
	}

	//Standard
//	@Getter
//	@Setter
//	static class ProblemCreateDTO {
//		private Long categoryYid;
//		private String categoryName;
//	}
//
//	@Getter
//	@Setter
//	static class Problem {
//		private Long categoryYid;//id;
//		private Category category;
//	}
//
//	@Getter
//	@Setter
//	static class Category {
//		private Long Yid;
//		private String name;
//	}

	//LOOSE
//	@Getter
//	@Setter
//	static class ProblemCreateDTO {
//		private Long categoryId1;
//		private String categoryName;
//	}
//
//	@Getter
//	@Setter
//	static class Problem {
//		private Long id;
//		private String id1;
//		private Category category;
//	}
//
//	@Getter
//	@Setter
//	static class Category {
//		private Long id;
//		private String name;
//	}
}
