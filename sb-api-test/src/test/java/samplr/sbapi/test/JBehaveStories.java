package samplr.sbapi.test;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.IDE_CONSOLE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestsConfiguration.class)
@ActiveProfiles("tests")
public class JBehaveStories extends JUnitStories {

    private static final int STORY_TIMEOUT = 120;

    @Autowired
    private ApplicationContext applicationContext;

    public JBehaveStories() {
        Embedder embedder = new Embedder();
        embedder.useEmbedderControls(embedderControls());
        embedder.useMetaFilters(Arrays.asList("-skip"));
        useEmbedder(embedder);
    }

    private EmbedderControls embedderControls() {
        return new EmbedderControls()
                .doIgnoreFailureInView(true)
                .useStoryTimeoutInSecs(STORY_TIMEOUT);
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(storyLoader())
                .useStoryReporterBuilder(storyReporterBuilder())
                .useParameterControls(parameterControls());
    }

    private ParameterControls parameterControls() {
        return new ParameterControls()
                .useDelimiterNamedParameters(true);
    }

    private StoryLoader storyLoader() {
        return new LoadFromClasspath();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), applicationContext);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
                "**/*.story", "**/excluded*.story");
    }

    private StoryReporterBuilder storyReporterBuilder() {
        return new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                .withFailureTrace(true)
                .withDefaultFormats()
                .withFormats(IDE_CONSOLE, Format.TXT, HTML);
    }

    //
//	private void initJBehaveConfiguration() {
//		Class<?> thisClass = this.getClass();
//		useConfiguration(new MostUsefulConfiguration()
//				.useStoryLoader(new LoadFromClasspath(thisClass.getClassLoader()))
//				.usePendingStepStrategy(new FailingUponPendingStep())
//				.useStepdocReporter(new PrintStreamStepdocReporter())
//				.useStoryReporterBuilder(new StoryReporterBuilder()
//						.withCodeLocation(CodeLocations.codeLocationFromClass(thisClass))
//						.withDefaultFormats()
//						.withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML, Format.STATS)
//						.withCrossReference(new CrossReference())
//						.withFailureTrace(true))
//				.useParameterConverters(new ParameterConverters()
//						.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd"))))
//				.useStepMonitor(new SilentStepMonitor()));
//	}

//	@Override

}
