/*
 * Allegro REST API
 * https://developer.allegro.pl/about
 *
 * The version of the OpenAPI document: latest
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package allegro.application.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains list of task results
 */
@ApiModel(description = "Contains list of task results")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class TaskReport {
  public static final String SERIALIZED_NAME_TASKS = "tasks";
  @SerializedName(SERIALIZED_NAME_TASKS)
  private List<CommandTask> tasks = null;


  public TaskReport tasks(List<CommandTask> tasks) {
    
    this.tasks = tasks;
    return this;
  }

  public TaskReport addTasksItem(CommandTask tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<CommandTask>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

   /**
   * List of task results
   * @return tasks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of task results")

  public List<CommandTask> getTasks() {
    return tasks;
  }



  public void setTasks(List<CommandTask> tasks) {
    this.tasks = tasks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskReport taskReport = (TaskReport) o;
    return Objects.equals(this.tasks, taskReport.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskReport {\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

