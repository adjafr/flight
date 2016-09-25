var bcrypt = require('bcryptjs');
//var ctrl = this;
import loginService from './login.service.js'



export default class LoginController
{


	  /* @ngInject */
	  constructor (loginService, $state, GlobalService) {
		this.user =
		{
				username: '',
				password: ''
		}

	    this.LoginService = loginService
	    this.$state = $state
	    this.GlobalService = GlobalService

	  }


		loginUser (user)
		{

			console.dir('login controller happened')
			this.LoginService.getUserDetails(user)

		}



}
