const React = require('react');

class Footer extends React.Component {
  docUrl (doc) {
    const baseUrl = this.props.config.baseUrl;
    const docsUrl = this.props.config.docsUrl;
    const docsPart = `${docsUrl ? `${docsUrl}/` : ''}`;
    return `${baseUrl}${docsPart}${doc}`;
  }


  render () {
    return (
      <footer className="nav-footer" id="footer">
        <section className="sitemap">
          <a href={this.props.config.baseUrl} className="nav-home">
            {this.props.config.footerIcon && (
              <img
                src={this.props.config.baseUrl + this.props.config.footerIcon}
                alt={this.props.config.title}
                width="66"
                height="58"
              />
            )}
          </a>
          <div className="community-column">
            <h5>Community</h5>
            <a href="#">Sponsor the project</a>
          </div>
          <div className="github-column">
            <h5>Github</h5>
            <p>
              <a
                className="github-button"
                data-icon="octicon"
                href={this.props.config.scalajsheresdkRepoUrl}
              >
                HereSdk.Scala.js
              </a>
            </p>
          </div>
        </section>
        <section className="copyright">{this.props.config.copyright}</section>
      </footer>
    );
  }
}

module.exports = Footer;
