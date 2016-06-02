/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.api.task;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.util.ProcessEngineTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

/**
 * @author Daniel Meyer
 *
 */
public class TaskReportTest {

  public ProcessEngineRule processEngineRule = new ProcessEngineRule(true);

  public ProcessEngineTestRule processEngineTestRule = new ProcessEngineTestRule(processEngineRule);

  @Rule
  public RuleChain ruleChain = RuleChain.outerRule(processEngineTestRule)
    .around(processEngineRule);

  @Test
  public void shouldReturnTaskCountsByGroup() {
    TaskService taskService = processEngineRule.getTaskService();

    Task task1 = taskService.newTask();
    taskService.saveTask(task1);
    taskService.addCandidateGroup(task1.getId(), "aGroupId");

    Task task2 = taskService.newTask();
    taskService.saveTask(task2);
    taskService.addCandidateGroup(task2.getId(), "aGroupId");

    Task task3 = taskService.newTask();
    taskService.saveTask(task3);
    taskService.addCandidateGroup(task3.getId(), "anotherGroupId");

    Task task4 = taskService.newTask();
     taskService.saveTask(task4);
  }

}
