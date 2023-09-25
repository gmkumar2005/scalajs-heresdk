/**
 * See https://docusaurus.io/docs/site-config
 */

const siteConfig = {
  title: 'HereSdk.Scala.js', // Title for your website.
  tagline: 'Simple, expressive, and type safe interactive maps library for Scalajs',
  url: 'https://gmkumar2005.github.io/HereSdk.Scala.js', // Your website URL
  baseUrl: '/',
  // Used for publishing and more
  projectName: 'scalajs-heresdk',
  organizationName: 'gmkumar2005',
  headerLinks: [
    { doc: 'documentation', label: 'Docs' },
    { doc: 'examples/non-interactive-map', label: 'Examples' },
    { doc: 'resources', label: 'Resources' },
    { blog: true, label: 'News' }
  ],
  stylesheets: [
    // Used for Material UI web components example
    "https://fonts.googleapis.com/css?family=Material+Icons&display=block",
    "https://fonts.googleapis.com/css?family=Roboto:300,400,500"
  ],
  blogSidebarTitle: { default: 'Recent News', all: 'All News' },

  // headerIcon: 'img/spiral-logo.svg',
  // footerIcon: 'img/spiral-logo.svg',
  // favicon: 'img/spiral-logo.svg',

  /* Colors for website */
  colors: {
    primaryColor: '#8BDBB8',
    secondaryColor: '#DB8BAE',
  },

  /* Custom fonts for website */
  /*
  fonts: {
    myFont: [
      "Times New Roman",
      "Serif"
    ],
    myOtherFont: [
      "-apple-system",
      "system-ui"
    ]
  },
  */

  // This copyright info is used in /core/Footer.js and blog RSS/Atom feeds.
  copyright: `Copyright © ${new Date().getFullYear()} gmkumar2005`,

  highlight: {
    // Highlight.js theme to use for syntax highlighting in code blocks.
    theme: 'atelier-estuary-dark',
  },
  staticDirectories: ['dist'],
  // Add custom scripts here that would be placed in <script> tags.
  // scripts: ['https://buttons.github.io/buttons.js'],


  // On page navigation for the current documentation page.
  onPageNav: 'separate',
  // No .html extensions for paths.
  cleanUrl: true,
  docsUrl: '',
  cname: 'heresdk.scalajs.dev',
  // Open Graph and Twitter card images.
  // ogImage: 'img/spiral-inverse-logo.svg',
  // twitterImage: 'img/spiral-inverse-logo.svg',

  customDocsPath: "website/target/mdoc",

  // For sites with a sizable amount of content, set collapsible to true.
  // Expand/collapse the links and subcategories under categories.
  // docsSideNavCollapsible: true,

  // Show documentation's last contributor's name.
  // enableUpdateBy: true,

  // Show documentation's last update time.
  // enableUpdateTime: true,

  // You may provide arbitrary config keys to be used as needed by your
  // template. For example, if you need your repo's URL...
  scalajsheresdkRepoUrl: 'https://github.com/gmkumar2005/scalajs-heresdk'
};

module.exports = siteConfig;
