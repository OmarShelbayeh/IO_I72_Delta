package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockTests {
    Component component;
    TransformJSONSpecificProperties transformJSONSpecificProperties = new TransformJSONSpecificProperties(component);

    @Test
    public void removeGivenPropertiesTest() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.removeGivenProperties("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit"})).thenReturn("size color");
        String result = transformJSONSpecificProperties.zachowajPodaneTest("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit"},mockObject);
        verify(mockObject).removeGivenProperties("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit"});
        assertEquals("Test: size color", result);
    }

    @Test
    public void removeGivenPropertiesTestOnlyOne() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.removeGivenProperties("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit", "size"})).thenReturn("color");
        String result = transformJSONSpecificProperties.zachowajPodaneTest("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit", "size"},mockObject);
        verify(mockObject).removeGivenProperties("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",new String[]{"fruit", "size"});
        assertEquals(result, "Test: color");
    }

    @Test
    public void structureTest() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.structure("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\",\"name\":\"Kim\"}")).thenReturn("fruit size color name");
        String result = transformJSONSpecificProperties.structureTest("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\",\"name\":\"Kim\"}",mockObject);
        verify(mockObject).structure("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\",\"name\":\"Kim\"}");
        assertEquals(result, "Test: fruit size color name");
    }

    @Test
    public void structureTestOnlyOne() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.structure("{\"fruit\":\"Apple\"}")).thenReturn("fruit");
        String result = transformJSONSpecificProperties.structureTest("{\"fruit\":\"Apple\"}",mockObject);
        verify(mockObject).structure("{\"fruit\":\"Apple\"}");
        assertEquals(result, "Test: fruit");
    }

    @Test
    public void removeTest() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.remove("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}","fruit")).thenReturn("{\"size\":\"Large\",\"color\":\"Red\"}");
        String result = transformJSONSpecificProperties.removeTest("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}","fruit",mockObject);
        verify(mockObject).remove("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}","fruit");
        assertEquals(result, "Test: {\"size\":\"Large\",\"color\":\"Red\"}");
    }

    @Test
    public void removeTestRemoveAll() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.remove("{\"fruit\":\"Apple\"}","fruit")).thenReturn("{}");
        String result = transformJSONSpecificProperties.removeTest("{\"fruit\":\"Apple\"}","fruit",mockObject);
        verify(mockObject).remove("{\"fruit\":\"Apple\"}","fruit");
        assertEquals(result, "Test: {}");
    }

    @Test
    public void findPathTest() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.findPath("{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}","q2")).thenReturn("maths quiz   question options answer");
        String result = transformJSONSpecificProperties.findPathTest("{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}","q2",mockObject);
        verify(mockObject).findPath("{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}","q2");
        assertEquals("Test: maths quiz   question options answer", result);
    }

    @Test
    public void findPathTestEmptyPath() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.findPath("{\"quiz\":{}}","q2")).thenReturn("");
        String result = transformJSONSpecificProperties.findPathTest("{\"quiz\":{}}","q2",mockObject);
        verify(mockObject).findPath("{\"quiz\":{}}","q2");
        assertEquals("Test: ", result);
    }

    @Test
    public void removeDuplicatesTest() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.removeDuplicates("fruit color q1 q1 size color Red size")).thenReturn("fruit q1 color Red size ");
        String result = transformJSONSpecificProperties.removeDuplicatesTest("fruit color q1 q1 size color Red size", mockObject);
        verify(mockObject).removeDuplicates("fruit color q1 q1 size color Red size");
        assertEquals("Test: fruit q1 color Red size ", result);
    }

    @Test
    public void removeDuplicatesTestNoDuplicates() {
        TransformJSONSpecificProperties mockObject = mock(TransformJSONSpecificProperties.class);
        when(mockObject.removeDuplicates("q")).thenReturn("q");
        String result = transformJSONSpecificProperties.removeDuplicatesTest("q", mockObject);
        verify(mockObject).removeDuplicates("q");
        assertEquals("Test: q", result);
    }
}
