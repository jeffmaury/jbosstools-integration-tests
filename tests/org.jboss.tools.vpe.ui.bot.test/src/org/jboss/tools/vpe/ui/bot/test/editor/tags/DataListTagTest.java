/*******************************************************************************
 * Copyright (c) 2007-2016 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.vpe.ui.bot.test.editor.tags;

import org.jboss.reddeer.common.wait.AbstractWait;
import org.jboss.reddeer.common.wait.TimePeriod;

/**
 * Tests Rich Faces dataList Tag behavior 
 * @author vlado pakan
 *
 */
public class DataListTagTest extends AbstractTagTest{
  private static final String ROW_0_VALUE = "!-* Row 0 Value";
  private static final String ROW_1_VALUE = "!-* Row 1 Value";
  private static final String ROW_2_VALUE = "!-* Row 2 Value";
  @Override
  protected void initTestPage() {
    initTestPage(TestPageType.XHTML,
      "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
      "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
      "  xmlns:f=\"http://java.sun.com/jsf/core\"\n" +
      "  xmlns:rich=\"http://richfaces.org/rich\"\n" +
      "  xmlns:h=\"http://java.sun.com/jsf/html\">\n" +
      "  <head>\n" +
      "  </head>\n" +
      "  <body>\n" +
      "    <f:view>\n" +
      "      <rich:dataList>\n" +
      "        <h:outputText value=\"" + DataListTagTest.ROW_0_VALUE + "\"/>\n" +
      "        <br/>\n" +
      "        <h:outputText value=\"" + DataListTagTest.ROW_1_VALUE + "\"/>\n" + 
      "        <br/>\n" +
      "        <h:outputText value=\"" + DataListTagTest.ROW_2_VALUE + "\"/>\n" +
      "      </rich:dataList>\n" +
      "    </f:view>\n" +
      "  </body>\n" + 
      "</html>");
  }

  @Override
  protected void verifyTag() {
    assertVisualEditorContains(getVisualEditor(),
      "UL", 
      new String[]{"class"},
      new String[]{"dr-list rich-datalist"},
      getTestPageFileName());
    assertVisualEditorContains(getVisualEditor(),
      "LI", 
      new String[]{"class"},
      new String[]{"dr-list-item rich-list-item"},
      getTestPageFileName());
    assertVisualEditorContainsNodeWithValue(getVisualEditor(),
      DataListTagTest.ROW_0_VALUE,
      getTestPageFileName());
    assertVisualEditorContainsNodeWithValue(getVisualEditor(),
      DataListTagTest.ROW_1_VALUE,
      getTestPageFileName());
    assertVisualEditorContainsNodeWithValue(getVisualEditor(),
      DataListTagTest.ROW_2_VALUE,
      getTestPageFileName());
    // check tag selecti
    getVisualEditor().selectDomNode(getVisualEditor().getDomNodeByTagName("LI",0), 0);
    AbstractWait.sleep(TimePeriod.getCustom(3));
    String selectedText = getSourceEditor().getSelectedText();
    String hasToStartWith = "<rich:dataList>";
    assertTrue("Selected text in Source Pane has to start with '" + hasToStartWith + "'" +
        "\nbut it is '" + selectedText + "'",
      selectedText.trim().startsWith(hasToStartWith));
    String hasEndWith = "</rich:dataList>";
    assertTrue("Selected text in Source Pane has to end with '" + hasEndWith + "'" +
        "\nbut it is '" + selectedText + "'",
      selectedText.trim().endsWith(hasEndWith));
  }

}
