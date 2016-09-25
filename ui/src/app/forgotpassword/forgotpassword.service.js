export default class ForgotPasswordService {
  /* @ngInject */
  constructor ($http, server, GlobalService) {
    this.$http = $http
    this.server = server
    this.GlobalService = GlobalService
  }

  getAllForgotPasswords () {
    return this.$http
      .get(this.server + 'forgotpasswords')
      .then((forgotpasswords) => forgotpasswords.data)
  }

  getForgotPassword (id) {
    return this.$http
      .get(this.server + 'forgotpasswords/' + id)
      .then((forgotpassword) => forgotpassword.data)
  }

  editForgotPassword (id, forgotpassword) {
    return () => {
      this.$http.patch(this.server + 'forgotpasswords/' + id, forgotpassword)
    }
  }
}