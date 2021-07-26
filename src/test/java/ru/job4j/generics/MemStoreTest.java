package ru.job4j.generics;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void testAdd() {
        User user = new User("2");
        UserStore userStore = new UserStore();
        userStore.add(user);
        assertThat(userStore.findBy("2").getId(), is("2"));
        Role role = new Role("45");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role);
        assertThat(roleStore.findBy("45").getId(), is("45"));
    }

    @Test
    public void testReplace() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        userStore.replace(userStore.findBy(user1.getId()).getId(), user3);
        assertThat(userStore.findBy(user3.getId()).getId(), is("3"));
    }

    @Test
    public void testDelete() {
        User user1 = new User("1");
        User user2 = new User("2");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        assertTrue(userStore.delete(user1.getId()));
    }

    @Test
    public void testFindBy() {
        User user1 = new User("1");
        User user2 = new User("2");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        assertThat(userStore.findBy(user1.getId()), is(user1));
    }
}