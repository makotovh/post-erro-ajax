/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.blog.makoto.errorajax.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
	}
	
	@Post
	@Path("/testaCodigo")
	public void testaCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new RuntimeException("Código Inválido");
		} 
		
		result.use(Results.json()).withoutRoot().from("Sucesso!!!!").serialize();
	}

}
