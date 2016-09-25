//var url = 'api/users/';

//import GlobalService from '../global.service'

var bcrypt = require('bcryptjs')

export default class LoginService {
  /* @ngInject */
	constructor ($http, GlobalService, $state) {
		this.$http = $http
		this.$state = $state
		this.url = 'http://localhost:8000/users/';
		this.GlobalService = GlobalService
		this.AllUsers	= this.$http
			.get(this.url)
			.then((allUsers) => allUsers.data)
	}

//	getUserDetails = function(id) { return this.$http.get(url + id) };
	getUserDetails ( user)

	{

		console.dir('login service happened')
		let temp = user.password
		console.log(temp)
		console.log("_____________")
		this.$http.get(this.url + user.username + '/validate' ).then((user) => {
		this.thisUser = user.data

			this.AllUsers	= this.$http
				.get(this.server + 'users')
				.then((userGet) => users.data)


		// if(temp === this.thisUser.password)
		if(bcrypt.compareSync(temp,this.thisUser.password))
		{
			console.dir('password is correct')

			this.GlobalService.loggedIn = true
			this.GlobalService.validUser = user
			console.dir(this.thisUser)
			this.$state.go('loginDetail/:id', {id: this.thisUser.id})

		}
		else{
			console.dir('password is incorrect')
		}

		})

	};







}
