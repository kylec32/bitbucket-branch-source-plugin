package com.cloudbees.jenkins.plugins.bitbucket;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.util.ListBoxModel;
import jenkins.scm.api.SCMHeadCategory;
import jenkins.scm.api.SCMSource;
import jenkins.scm.api.trait.SCMSourceContext;
import jenkins.scm.api.trait.SCMSourceTrait;
import jenkins.scm.api.trait.SCMSourceTraitDescriptor;
import jenkins.scm.impl.trait.Discovery;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;

public class ApprovedPullRequestTrait  extends SCMSourceTrait {

    private int strategyId;

    /**
     * Constructor.
     */
    @DataBoundConstructor
    public ApprovedPullRequestTrait(int strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void decorateContext(SCMSourceContext<?, ?> context) {
        ((BitbucketSCMSourceContext) context).requireApproval(true);
        switch (strategyId) {
            case 2:
                ((BitbucketSCMSourceContext) context).requireApproval(true);
                ((BitbucketSCMSourceContext) context).requireNonAuthorApproval(false);
                break;
            case 3:
                ((BitbucketSCMSourceContext) context).requireApproval(true);
                ((BitbucketSCMSourceContext) context).requireNonAuthorApproval(true);
            default:
                ((BitbucketSCMSourceContext) context).requireApproval(false);
                ((BitbucketSCMSourceContext) context).requireApproval(false);
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean includeCategory(@NonNull SCMHeadCategory category) {
        return category.isUncategorized();
    }

    /**
     * Our descriptor.
     */
    @Extension
    @Discovery
    public static class DescriptorImpl extends SCMSourceTraitDescriptor {

        /**
         * {@inheritDoc}
         */
        @Override
        public String getDisplayName() {
            return "Require approvals on pull request";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<? extends SCMSourceContext> getContextClass() {
            return BitbucketSCMSourceContext.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<? extends SCMSource> getSourceClass() {
            return BitbucketSCMSource.class;
        }

        /**
         * Populates the strategy options.
         *
         * @return the strategy options.
         */
        @NonNull
        @Restricted(NoExternalUse.class)
        @SuppressWarnings("unused") // stapler
        public ListBoxModel doFillStrategyIdItems() {
            ListBoxModel result = new ListBoxModel();
            result.add("No approval necessary.", "1");
            result.add("An approval required.", "2");
            result.add("Non-author approval required.", "3");
            return result;
        }
    }

}
