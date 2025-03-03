package io.dagger.modules.javaglamour;

import io.dagger.client.DaggerQueryException;
import io.dagger.client.File;
import io.dagger.module.AbstractModule;
import io.dagger.module.annotation.Function;
import io.dagger.module.annotation.Object;
import java.util.concurrent.ExecutionException;

/** Print markdown content */
@Object
public class JavaGlamour extends AbstractModule {
  /**
   * Render a markdown string
   *
   * @param content markdown string to print
   */
  @Function
  public String markdown(String content)
      throws ExecutionException, DaggerQueryException, InterruptedException {
    return dag.glow().displayMarkdown(content);
  }

  /**
   * Render a markdown file
   *
   * @param file file to render the content as markdown
   */
  @Function
  public String markdownFile(File file)
      throws ExecutionException, DaggerQueryException, InterruptedException {
    return markdown(file.contents());
  }
}
