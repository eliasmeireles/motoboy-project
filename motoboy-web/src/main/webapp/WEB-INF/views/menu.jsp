<header>
	<div class="header-menu background-primary">
		<div class="menu-responsiv">
			<div class="menu-ico">
				<div class="inner"></div>
				<div class="inner"></div>
				<div class="inner"></div>
			</div>
			<h5 class="resp-text color_primary_light font-primary-bold">Menu</h5>
		</div>
		<div class="menu-container">
			<ul class="menu-nav-bar background-secondary_dark">
				<li class="nav-link font-primary"><a class="navication-link" href="${contextPath}">Home</a></li>
				<li class="nav-link font-primary"><a class="navication-link" href="${contextPath}motoboy">Motodoy Cadastro</a></li>
				<li class="nav-link font-primary"><a class="navication-link" href="${contextPath}cliente">Cliente cadastro</a></li>
				<li class="nav-link font-primary"><a class="navication-link" href="${contextPath}motoboy/lista">Lista de Motoboys</a></li>
				<li class="nav-link font-primary"><a class="navication-link" href="${contextPath}moto">Adicionar Moto</a></li>
				<li class="nav-link nav-link-login font-primary color_primary_light">Login</li>
			</ul>
			<div class="login-form background-primary_dark">
				<div class="motoboy-login login-container">
					<label class="loogin-title title-motoboy color_primary_light background-primary">Motoboy</label>
					<form action="${contextPath }motoboy/login" method="post" class="motoboy-login_container">
						<div class="input email">
							<input type="email" placeholder="Email" name="email" class="form-box font-primary background-secondary_light">
						</div>
						<div class="input password">
							<input type="password" placeholder="Senha" name="senha" class="form-box font-primary background-secondary_light">
						</div>
						<div class="recuperar-senha">
							<a class="esq-senha font-primary-italic" href="${contextPath }">Enqueceu sua senha?</a>
						</div>
						<div class="btn">	
							<button type="submit" class="btn-submit background-primary color-secondary_light font-primary-bold">Entrar</button>
						</div>
					</form>
				</div>					
					
				<div class="clinete-login login-container">
					<label class="loogin-title title-cliente color_primary_light background-primary">Cliente</label>
					<form action="${contextPath }cliente/login" method="post" class="cliente-login_container">
						<div class="input email">
							<input type="email" placeholder="Email" name="email" class="form-box font-primary background-secondary_light">
						</div>
						<div class="input password">
							<input type="password" placeholder="Senha" name="senha" class="form-box font-primary background-secondary_light">
						</div>
						<div class="recuperar-senha">
							<a class="esq-senha font-primary-italic" href="${contextPath }">Enqueceu sua senha?</a>
						</div>
						<div class="btn">	
							<button type="submit" class="btn-submit background-primary color-secondary_light font-primary-bold">Entrar</button>
						</div>
					</form>
				</div>
			</div>
			<div class="remove-login"></div>
			<div class="memove-menu"></div>
		</div>
	</div>
</header>
