import GlobalService from '../global.service'


var bcrypt = require('bcryptjs');
//var ctrl = this;
import RegisterService from './register.service.js'

export default class RegisterController {
	
	  /* @ngInject */
	  constructor (registerService, $state, GlobalService) {
		this.user = 
		{
				username: '',
				password: '',
//				userConfirmPassword: '',  //must add to back end / java
//				userSecurityQuestion: '', //must add to back end / java
//				userSecurityAnswer: '', //must add to back end / java
//				userEmail: '', //must add to back end / java
				name: ''
//				userMale: '',
//				userFemale: '',
		}

	    this.RegisterService = registerService
	    this.$state = $state
	    this.GlobalService = GlobalService
//	    this.UserService = userService
	  }    	

//	angular.module('app').controller('register.controller', ['register.service', '$routeParams', '$location', function(UserDetailService, $routeParams, $location)
//	{

//	Register = function()
//	{
//	RegisterService.getUserDetails(id).then(function(result)
//	{
//		ctrl.user = result.data;
//	}
//	}
		registerUser (user) 
		{
		
			console.dir('stuff happened')
			this.RegisterService.postUserDetails(user).then(() => {this.$state.go('users')})
			
		}
	
	         //]);
	
	

}