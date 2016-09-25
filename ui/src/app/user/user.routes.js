export default function route ($stateProvider) {
  $stateProvider
  

  
    .state('users', {
      url: '/users',
      component: 'appUser',
      resolve: {
        entities: function (userService) {
          return userService.getAllUsers()
        }
      }
    })
    .state('userDetail', {
      url: '/users/:id',
      component: 'appUserDetail',
      resolve: {
        entity: function (userService, $stateParams) {
          return userService.getUser($stateParams.id)
        }
      }
    })
}