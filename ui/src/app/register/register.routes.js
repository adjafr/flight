export default function route ($stateProvider) {
  $stateProvider



    .state('registers', {
      url: '/registers',
      component: 'appRegister'

    })
    .state('registerDetail', {
      url: '/registers/:id',
      component: 'appRegisterDetail'

    })
}
