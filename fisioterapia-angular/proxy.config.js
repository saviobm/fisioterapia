const proxy = [
  {
    context: '/fisioterapia',
    target: 'http://localhost:9000',
    pathRewrite: {'^/fisioterapia' : ''}
  }
];

module.exports = proxy;