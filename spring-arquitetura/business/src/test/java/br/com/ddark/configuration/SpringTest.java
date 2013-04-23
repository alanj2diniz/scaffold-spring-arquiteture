package br.com.ddark.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ddark.service.IPessoaService;

public class SpringTest extends AbstractTest {
	
	@Autowired
	private IPessoaService pessoaService;
	
	@Test
	public void injectionTest() {
		Assert.assertNotNull(pessoaService);
	}

}
