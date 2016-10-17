import GlobalService from '../global.service'


var bcrypt = require('bcryptjs');

import RegisterService from './register.service.js'

export default class RegisterController {

	  /* @ngInject */
	  constructor (registerService, $state, GlobalService) {
		this.user =
		{
				username: '',
				password: '',

				name: ''

		}

	    this.RegisterService = registerService
	    this.$state = $state
	    this.GlobalService = GlobalService
	  }


		registerUser (user)
		{

			console.dir('stuff happened')
			this.RegisterService.postUserDetails(user).then(() => {this.$state.go('users')})

		}


}
