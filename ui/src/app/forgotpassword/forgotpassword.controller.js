export default class ForgotPasswordController {
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
  
}