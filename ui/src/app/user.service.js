import GlobalService from '../global.service'

export default class UserService {
  /* @ngInject */
  constructor ($http, server, GlobalService) {
    this.$http = $http
    this.server = server
    this.GlobalService = GlobalService
  }

  getAllUsers () {
    return this.$http
      .get(this.server + 'users')
      .then((users) => users.data)
  }

  getUser (id) {
    return this.$http
      .get(this.server + 'users/' + id)
      .then((user) => user.data)
  }

  editUser (id, user) {
    return () => {
      this.$http.patch(this.server + 'users/' + id, user)
    }
  }
}
