const React = require('react');

const CompLibrary = require('../../core/CompLibrary.js');

// const MarkdownBlock = CompLibrary.MarkdownBlock; /* Used to read markdown */
const Container = CompLibrary.Container;
const GridBlock = CompLibrary.GridBlock;

class HomeSplash extends React.Component {
  render () {
    const {siteConfig, language = ''} = this.props;
    const {baseUrl, docsUrl} = siteConfig;
    const docsPart = `${docsUrl ? `${docsUrl}/` : ''}`;
    const langPart = `${language ? `${language}/` : ''}`;
    const docUrl = (doc) => `${baseUrl}${docsPart}${langPart}${doc}`;

    const SplashContainer = (props) => (
      <div className="homeContainer">
        <div className="homeSplashFade">
          <div className="wrapper homeWrapper">{props.children}</div>
        </div>
      </div>
    );

    const Logo = ({img_src}) => (
      <div className="projectLogo">
        <img src={img_src} alt="Project Logo"/>
      </div>
    );

    const ProjectTitle = ({title, tagline}) => (
      <h2 className="projectTitle">
        {title}
        <small>{tagline}</small>
      </h2>
    );

    const PromoSection = (props) => (
      <div className="section promoSection">
        <div className="promoRow">
          <div className="pluginRowBlock">{props.children}</div>
        </div>
      </div>
    );

    const Button = ({href, target, children}) => (
      <div className="pluginWrapper buttonWrapper">
        <a className="button" href={href} target={target}>
          {children}
        </a>
      </div>
    );

    return (
      <SplashContainer>
        <div className="inner">
          <ProjectTitle
            title="HereSdk.Scala.js"
            tagline="Simple, expressive, and type safe interactive maps library for Scalajs"
          />
          <PromoSection>
            <Button href="https://github.com/gmkumar2005/scalajs-heresdk">Github</Button>
            <Button href={docUrl('examples/hello-world')}>Interactive examples</Button>
            <Button href={docUrl('documentation')}>Documentation</Button>
          </PromoSection>
          <div className="-problem">
              HereSdk.Scala.js empowers you to create location and map based applications featuring rich and customizable using type-safe class and method libraries. Its elegant and expressive patterns are built upon a robust foundation comprising the <a href="https://developer.here.com/develop/javascript-api"> HERE Maps API for JavaScript </a> and the <a href="https://www.scala-js.org/">Scala.js</a> platform, making development straightforward yet powerful.
              </div>
        </div>
      </SplashContainer>
    );
  }
}

class Index extends React.Component {
  render () {
    const {config: siteConfig, language = ''} = this.props;
    const {baseUrl} = siteConfig;

    return (
      <div>
        <HomeSplash siteConfig={siteConfig} language={language}/>
        <div className="mainHomeContainer">
          {
            this.renderSection({
              title: "Key Features",
              layout: "threeColumn",
              contents: [
                {
                  title: 'Power of HERE Maps',
                  content: 'With these unofficial Scala.js bindings, developers can tap into the robust capabilities of the HERE Maps API. From geocoding and routing to interactive maps and location-based services, you gain access to a world of spatial data and mapping functionality.'
                },
                {
                  title: 'Scala.js',
                  content: "Built specifically for Scala.js, this library ensures a smooth and efficient development experience. Leverage the strengths of Scala, a statically typed language, to create reliable and maintainable applications."
                },
                {
                  title: 'Seamless Integration',
                  content: 'Integration with HERE Maps becomes effortless with these bindings. Quickly incorporate HERE Maps into your Scala.js projects, reducing development time and complexity.'
                }
              ]
            })
          }
          <div className="-homeGetStartedSection x-dark">
            {
              this.renderSection({
                className: "x-dark",
                title: "Get Started",
                layout: "threeColumn",
                preContents: (
                  <React.Fragment>
                    <p>
                      Following links will get you started with HereSdk.Scala.js.
                    </p>

                  </React.Fragment>
                ),
                contents: [
                  {
                    title: '[Live Examples](/examples/hello-world)',
                    content: "Live app and its code side-by-side.<br />What sorcery is this?"
                  },
                  {
                    title: '[Documentation](/documentation)',
                    content: 'Always current, explaining both high level ideas and gritty details. Worth reading back-to-back.'
                  },
                  {
                    title: '[Resources](/resources)',
                    content: 'Quickstart, articles & videos, addons, starter kits, and other useful stuff.'
                  },
                ]
              })
            }
             </div>
        </div>
      </div>
    );
  }

  renderSection ({title, preContents, layout, contents, className}) {
    return (
      <Container
        className={"-homeSection " + (className ? className : '')}
      >
        {title && <h1>{title}</h1>}
        {preContents}
        <GridBlock
          align="center"
          contents={contents}
          layout={layout}
        />
      </Container>
    );
  }
}

module.exports = Index;
