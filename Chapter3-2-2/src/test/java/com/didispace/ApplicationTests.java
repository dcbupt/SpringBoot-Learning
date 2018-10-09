package com.didispace;

import com.didispace.domain.User;
import com.didispace.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {

		// 创建10条记录
		userRepository.save(new User("AAA", 10, new Date()));
		userRepository.save(new User("BBB", 20, new Date()));
		userRepository.save(new User("CCC", 30, new Date()));
		userRepository.save(new User("DDD", 40, new Date()));
		userRepository.save(new User("EEE", 50, new Date()));
		userRepository.save(new User("FFF", 60, new Date()));
		userRepository.save(new User("GGG", 70, new Date()));
		userRepository.save(new User("HHH", 80, new Date()));
		userRepository.save(new User("III", 90, new Date()));
		userRepository.save(new User("JJJ", 100, new Date()));

		//List<User> users = userRepository.findAll();
		//users.sort(Comparator.comparing(User::getDate, Comparator.reverseOrder()));
		List<User> users = userRepository.findByDateDesc();
		users.forEach(user -> {
			System.out.println(user);
		});



		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

	}


}
