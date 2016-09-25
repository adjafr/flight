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

// var bcrypt = require('bcryptjs')
//
// export default
// class UserService {
//  /* @ngInject */
//  constructor ($http, $state) {
//    this.$http = $http
//
//    this.getAllUsers = function() {
//      return this.$http.get('http://localhost:8000/user').then((allUsers) => allUsers.data)
//    }
//
//
//  this.newUser = function (allUsers, user) {
//   let found = allUsers.map(e => e.userName).indexOf(user.userName)
//    if(found === -1)
//    {
//     user.password = bcrypt.hashSync(user.password, 8)
//     this.$http.post('http://localhost:8000/user', user)
//   }
//   }
//
//   this.getUser = function (allUsers, userCheck) {
//     console.dir(allUsers)
//     let checkAll = allUsers
//     .map(e => e.userName).indexOf(userCheck.userName)
//     console.dir(checkAll)
//     let userfind = allUsers[checkAll]
//     console.dir(userfind)
//      if(checkAll !== -1)
//       {
//         if(bcrypt.compareSync(userCheck.password, userfind.password)){
//           this.$http.get('http://localhost:8000/user/' + userfind.id)
//             .then(function() { $state.go('userHomepage/:id', {id: userfind.id})})
//
//         }
//       }
//
//  }
//
//  this.newItinerary = function(user){
//    this.$http.get('http://localhost:8000/user/flightFind', user.origin, user.destination)
//    .then((itinerary) => itinerary.data)
//  }
//  }
//  }
