
var bcrypt = require('bcryptjs')
import GlobalService from '../global.service'

export default class RegisterService {
  /* @ngInject */
	constructor ($http, GlobalService) {
		this.$http = $http
		this.url = 'http://localhost:8000/users';
		this.GlobalService = GlobalService
	}

	getUserDetails = function(id) { return $http.get(this.url + id) };
	postUserDetails (user)
	{
		user.password = bcrypt.hashSync(user.password, 8)
		console.dir('more stuff happened')
		return this.$http.post(this.url, user)
	};
}
