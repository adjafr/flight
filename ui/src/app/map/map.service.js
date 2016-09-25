/* @ngInject */
class MapService {
  constructor ($http) {
    this.$http = $http
//    this.apiUrl = apiUrl
    this.server = 'http://localhost:8000'
  }

  getMarkerByCityName (name) {
    return this.$http
      .get(`${this.server}/location/name`, { params: { name } }) //apiUrl
      .then(result => result.data)
  }
}

export default MapService
