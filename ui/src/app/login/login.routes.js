export default function route ($stateProvider) {
  $stateProvider



    .state('logins', {
      url: '/logins',
      component: 'appLogin'

    })
    .state('loginDetail/:id', {
      url: '/users/:id',
      component: 'appLoginDetail',
      resolve:
        {
        entity: function (loginService, $stateParams) {
          console.log($stateParams.id);
          return loginService.getUser($stateParams.id)
        }
      }
      })

}
