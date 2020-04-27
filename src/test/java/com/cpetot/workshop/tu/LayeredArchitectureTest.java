package com.cpetot.workshop.tu;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.cpetot.workshop.tu", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

	@ArchTest
	static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

			.layer("Controllers").definedBy("com.cpetot.workshop.tu.web..")
			.layer("Services").definedBy("com.cpetot.workshop.tu..services..")
			.layer("Persistence").definedBy("com.cpetot.workshop.tu.repository..")
			.layer("Model").definedBy("com.cpetot.workshop.tu.entities..")

			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
			.whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
			.whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services", "Controllers")
			.whereLayer("Model").mayOnlyBeAccessedByLayers("Controllers", "Services", "Persistence");

}
